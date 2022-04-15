# trendyol-selenium-project

For run the test with default config -> ``mvn clean test``

Specify browser (chrome, firefox, safari) -> ``mvn clean test -Dbrowser=firefox``

Specify headless mode -> ``mvn clean test -Dbrowser=chrome -Dheadless=true``

You can also run tests in parallel (TestNG) -> ``mvn clean test -Dparallel="methods"``

## Trendyol UI Automation 

### Add Basket E2E Test

Scenario:

- Go to the ``trendyol.com``
- Go to ``TV & Görüntü & Ses`` sub category in the ``ELEKTRONIK`` category
- Click first product (after this action, new browser tab will open)
- Add product to basket and close tab
- Go to basket page
- Check that the product has been added to the cart

### Sign up E2E Test

Scenario

- Go to the ``10minutemail.net`` and take a mail
- Go to the ``trendyol.com``
- Click Sign In button
- Click Sign Up button
- Try to sign up with taken mail in first step
- Check that the email verify modal is visible
