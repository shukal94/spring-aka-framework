#Web 
Provides an essential kit for Web automation
##Installation
1. Import this artifact as a maven dependency
##Configuration
Example
platformName, version, acceptInsecureCerts are mandatory fields
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