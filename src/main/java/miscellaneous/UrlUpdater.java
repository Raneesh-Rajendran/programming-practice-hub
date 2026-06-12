package main.java.miscellaneous;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;

public class UrlUpdater {

  public static String updateURLForSharing(
      String urlStr, Map<String, String> requiredParams, boolean addNewParamsToHashComponent)
      throws URISyntaxException {
    URI uri = new URI(urlStr);

    Map<String, String> queryParams = parseParams(uri.getRawQuery());
    Map<String, String> fragmentParams = parseParams(uri.getRawFragment());

    for (String key : requiredParams.keySet()) {
      if (addNewParamsToHashComponent) {
        queryParams.remove(key);
      } else {
        fragmentParams.remove(key);
      }
    }

    if (addNewParamsToHashComponent) {
      fragmentParams.putAll(requiredParams);
    } else {
      queryParams.putAll(requiredParams);
    }

    String newQuery = buildParamString(queryParams);
    String newFragment = buildParamString(fragmentParams);

    URI newUri =
        new URI(
            uri.getScheme(),
            uri.getAuthority(),
            uri.getPath(),
            newQuery.isEmpty() ? null : newQuery,
            newFragment.isEmpty() ? null : newFragment);

    return newUri.toString();
  }

  private static Map<String, String> parseParams(String raw) {
    Map<String, String> map = new LinkedHashMap<>();
    if (raw == null || raw.isEmpty()) return map;

    String[] pairs = raw.split("&");
    for (String pair : pairs) {
      int idx = pair.indexOf('=');
      if (idx == -1) {
        map.put(decode(pair), ""); // key with no value
      } else {
        map.put(decode(pair.substring(0, idx)), decode(pair.substring(idx + 1)));
      }
    }
    return map;
  }

  private static String buildParamString(Map<String, String> params) {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      if (!sb.isEmpty()) sb.append("&");
      sb.append(encode(entry.getKey()));
      if (!entry.getValue().isEmpty()) {
        sb.append("=").append(encode(entry.getValue()));
      }
    }
    return sb.toString();
  }

  private static String encode(String input) {
    return input.replace(" ", "%20");
  }

  private static String decode(String input) {
    return input.replace("%20", " ");
  }

  public static void main(String[] args) throws URISyntaxException {
    // Basic UTM parameters added
    Map<String, String> utmParams = new LinkedHashMap<>();
    utmParams.put("utm_source", "Facebook");
    utmParams.put("utm_campaign", "Echobox");
    utmParams.put("utm_medium", "Social");

    // Criteria: verifies UTM params are appended correctly when no query/fragment exists
    String baseUrl =
        "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/";
    System.out.println("Test-1: no query or fragment, add to query");
    System.out.println(updateURLForSharing(baseUrl, utmParams, false));

    // Criteria: verifies UTM params go in the fragment when requested
    System.out.println("Test-2: Same as above, but add to fragment instead");
    System.out.println(updateURLForSharing(baseUrl, utmParams, true));

    // Criteria: verifies both parts are preserved and UTM added in correct section
    String urlWithBoth = "https://example.com/page?existing=123#section=456";
    System.out.println("Test 3 – Existing query and fragment, add to query");
    System.out.println(updateURLForSharing(urlWithBoth, utmParams, false));

    System.out.println("Test 4 – Existing query and fragment, add to fragment");
    System.out.println(updateURLForSharing(urlWithBoth, utmParams, true));

    // Criteria: verifies keys in the opposite section are removed when adding new UTM
    String conflictUrl =
        "https://example.com/page?utm_source=Old&keep=1#utm_campaign=OldCampaign&utm_medium=OldMedium";
    System.out.println("Test 5 – Conflict resolution, add to query");
    System.out.println(updateURLForSharing(conflictUrl, utmParams, false));
    // Expect: utm_* in query, removed from fragment

    System.out.println("Test 6 – Conflict resolution, add to fragment");
    System.out.println(updateURLForSharing(conflictUrl, utmParams, true));
    // Expect: utm_* in fragment, removed from query

    // Criteria: verifies an empty value results in key with no '='
    Map<String, String> emptyValueParam = new LinkedHashMap<>();
    emptyValueParam.put("utm_medium", "");
    System.out.println("Test-7: Include UTM param with empty value");
    System.out.println(updateURLForSharing(baseUrl, emptyValueParam, false));
    // Expect: ...?utm_medium

    // Criteria: verifies UTM params are correctly added from scratch
    String cleanUrl = "https://news.com/article";
    System.out.println("Test-8: Clean URL, add UTM to query");
    System.out.println(updateURLForSharing(cleanUrl, utmParams, false));

    System.out.println("Test-9: Clean URL, add UTM to fragment");
    System.out.println(updateURLForSharing(cleanUrl, utmParams, true));

    // Criteria: verifies minimal encoding (space to %20)
    Map<String, String> specialCharParams = new LinkedHashMap<>();
    specialCharParams.put("utm source", "Facebook Audience");
    System.out.println("Test-10: UTM keys with special characters");
    System.out.println(updateURLForSharing(cleanUrl, specialCharParams, false));
    // Expect: utm%20source=Facebook%20Audience

    // Invalid URL format: verifies behavior on bad input (will throw URISyntaxException)
    try {
      System.out.println("Test 11 – Invalid URL:");
      System.out.println(updateURLForSharing("http://", utmParams, false));
    } catch (URISyntaxException e) {
      System.out.println("Caught URISyntaxException as expected for invalid URL.");
    }
  }
}
