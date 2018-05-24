Feature: Test of content AddToYourOrder page

  Background:
  #  Given User is on wordpress website "http://wordpress.com"
   # When User clicks to login button
    #Then Email login page is displayed

    @wordpress @login
  Scenario: Checking of CartSubtotal content
      Given User is on wordpress website "http://wordpress.com"
      When User clicks to login button
      Then Email login page is displayed
      When User enter email and clicks continue button
      Then Password login page is displayed
      When User enters password and press Login Button
      Then Main loged pag is displayed
      When User press avatar
      Then Personal Page is displayed
      When User clikcs notification link
      Then Notification page is displayed
      When User Press checkbox
      Then Checkbox is unselected
