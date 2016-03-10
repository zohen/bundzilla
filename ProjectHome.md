Online Resource Bundle Editor **Bundzilla** is for creating resource bundles using a web-based interface. It allows easy collaboration of application developers and translators via email notifications. There is no longer need to install anything on your desktop!

An exemplary scenario of using this application is the following:

  * a project admin creates a project
  * in this project admin creates a bundle
  * admin assigns developers that can add/modify/delete entries in English
  * admin adds languages to the bundle
  * for each language admin assigns one or more translators (developer can be translator too)
  * when developer adds/modifies an entry, an email is sent to all translators and color of the translations changes
  * translator logs in, he sees only columns of languages that he was assigned,  he does the translation, after pressing submit the color of this particular translation changes to initial
  * after all translations for this entry are made, an email is sent to admin and (possibly) developers
  * after all translations on the bundle are complete, an email is sent too
  * when the bundle is in good shape, admin can download it in the form of `*`.properties files, he can use to download them either in UTF-8 format or in ASCII (i.e. already converted using, e.g. java2native)