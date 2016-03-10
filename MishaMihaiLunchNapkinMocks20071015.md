# First mocks and first class diagram on napkins #

Here they are

## Login and Register page ##

![http://bundzilla.googlecode.com/svn/wiki/images/login_register_mock.jpg](http://bundzilla.googlecode.com/svn/wiki/images/login_register_mock.jpg)

These are pretty standard. In addition:

  * login should have also "Remember Me" checkbox
  * registration page should also have the CAPTCHA part

## Resource Bundle View ##

![http://bundzilla.googlecode.com/svn/wiki/images/resource_bundle_view.jpg](http://bundzilla.googlecode.com/svn/wiki/images/resource_bundle_view.jpg)

This is a mock of a main page of the application: the resource bundle view. On this page we see the following parts:

  * Header - currently contains only logout link, maybe there will be more of them...

  * Left Menu - tree-based menu system to navigate to different pages
    * My Account - information about the current user
    * My Contacts - a convenience page to store the people you ever worked with on different projects
    * My Projects - list of projects you are working on, for each project we have the following submenus:
      * Team - the team roster for this project. Each team member has one or more languages associated with them
      * Bundles - each project can have multiple resource bundles (i.e. main ApplicationResources.properties, CaptionResources.properties, MessageResources.properties, and so on). Clicking on one of the bundle names opens the main bundle view

  * Main Panel - when a user click on the left menu item, they are shown the corresponding page. In this case we see the bundle view.

### Bundle View ###

It is shown as a grid, with first column as the **key** for each entry in the resource bundle, other columns are corresponding to the languages we are translating this bundle to. On this picture we can see the following entries:

  * in AppResources\_en\_US.properties:
    * main.login=login
    * main.register=Register
  * in AppResources\_ru\_RU.properties:
    * main.login=Логин
    * main.register=Зарегистрироваться
and so on for other languages and other entries...

Some rules regarding this view and the process overall:

  1. User can have different roles in a project: "project admin" or "translator" (or both)
    1. **Project Admin** can create or remove bundles, add/remove team members, add/remove/modify entries and do all things that are available to translators
    1. **Translator** can only translate to their language(s)
  1. Each entry has a **"base language"** - in most cases it will be English (until the world changes its lingua franca :D )
    1. If the base language translation changes, then all translations in other languages for this entry become dirty and are highlighted in red on the resource bundle view
    1. When a new entry is added, emails are sent to each translator
    1. When the base language translation of an existing entry is modified, emails are sent to translators
      * We may want to think about not sending emails after each entry, but accumulate several entries and send emails only every hour or so... Otherwise, the translators will be bombarded with huge number of emails
    1. If an entry is removed there is no need to send any emails
  1. The "Configure" link, that is visible at the right-top corner under "Logout" will show a popup modal window with settings for the resource bundle view. In these settings:
    * user will choose to show only languages that are assigned to them
    * or to show all languages
  1. The translation is only editable for those people who are assigned to this language, for all others (excluding project admin) the pertinent grid cell is read-only.


## First Class Diagram ##

![http://bundzilla.googlecode.com/svn/wiki/images/bundzilla_class_diagram.jpg](http://bundzilla.googlecode.com/svn/wiki/images/bundzilla_class_diagram.jpg)

This class diagram reflects the following rules:

  1. User can be assigned to a project to translate to certain languages (association class ProjectUserLanguageAssignment)
  1. **NOT ON THIS DIAGRAM, WE FORGOT IT:** One or more users can be project admins, we need to add an association class ProjectAdmin
    * **ON THIS DIAGRAM IT'S SHOWN DIFFERENTLY:** Each project should have a "base language" (on the diagram we show a line between Bundle and Language and call it "reference language", I suggest to do it on the Project level for the sake of simplicity and call it "base language")
  1. Each Project can have multiple bundles
  1. Each Bundle can have multiple entries. A typical entry have the following attributes:
    * Surrogate ID (e.g. 1, 2, 3...)
    * Key (e.g. "main.login", "main.register",...)
    * Possibly Dirty Flag (this is arguable, we might need to work with timestamps, to be discussed)
  1. Each Entry can have multiple Translations, each translation for a particular language.