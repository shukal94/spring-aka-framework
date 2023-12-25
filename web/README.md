# Web 
Provides an essential kit for Web automation
## Installation
1. Import this artifact as a maven dependency;
2. Import
```xml
<dependency>
    <groupId>ch.shukalovi.selenium.base.framework.common</groupId>
    <artifactId>common-util</artifactId>
    <version>${framework.utils.version}</version>
</dependency>
```
to enable threaded web-driver mode;
3. Install and start selenium grid locally.
## Configuration
browser, baseUrl, platformName, version, acceptInsecureCerts, pageLoadStrategy (if using `edge`) are mandatory fields
```yaml
web:
  browser: chrome
  baseUrl: http://google.com
```
, where `browser` has a value one of [chrome, firefox, edge]

Example for `chrome`
```yaml
chrome:
  platformName: mac
  version: 119.0
  args: --no-sandbox, --disable-infobars, --service-type, --start-maximized, --disable-extensions, --disable-notifications
  acceptInsecureCerts: true
  prefs:
    credentials_enable_service: false
    download:
      prompt_for_download: false
    profile:
      password_manager_enabled: false
      'content_settings.pattern_pairs.*.multiple-automatic-downloads': 1
      default_content_settings:
        popups: 0
```
Example for `firefox`
```yaml
firefox:
  platformName: mac
  version: 102.0
  acceptInsecureCerts: true
  prefs:
    browser:
      helperApps:
        neverAsk:
          saveToDisk: application/octet-stream
      download:
        folderList: 2
        manager:
          showWhenStarting: false
```
Example for `edge`
```yaml
edge:
  platformName: mac
  version: 102.0
  acceptInsecureCerts: true
  pageLoadStrategy: eager
  capabilities:
    EnableNativeEvents: false
    ignoreZoomSetting: true
    'ms:edgeChromium': true
```