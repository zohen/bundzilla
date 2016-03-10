# Introduction #

Due to a bug in the Seam support of RHDS, you will not be able to create a Seam configuration and the Bundzilla projects will fail to compile. You need to follow the following steps to create a dummy project using the wizard, during which you can successfully configure all that's needed for building Bundzilla from the IDE.

# Details #
Here are the steps for priming your brand-new RHDS workspace for Seam. These must be followed any time you switch to a new desktop, not just once right after the installation.

  1. Open the RHDS IDE.
  1. Choose `Help` -> `Welcome` from the menus.
  1. Choose `Create new...`.
  1. Choose `Create Seam Project`.
  1. The wizard will start. Enter `Test` for the "Project name".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_1.JPG
  1. Click the "New" in the "Target Runtime" section to create a Server configuration.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_2.JPG
  1. Choose "JBoss 4.2 Runtime" from the list and click "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_3.JPG
  1. Enter the Home directory for your installation, make sure the right "JRE" (it should actually be a JDK) is selected, choose the "default" server and click "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_4.JPG
  1. Click "Finish" (leave "User Name" and "Password" empty).
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_5.JPG
  1. You're back to the starting page. Choose "Dynamic Web Project with Seam 1.2" from the "Configurations" drop-down, and hit "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_6.JPG
  1. Select the "Java Persistence" option and hit "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_7.JPG
  1. Leave everything to the default and hit "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_8.JPG
  1. Click "Add connection..." to configure the MySQL database access for RHDS.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject_9.JPG
  1. Pick "SQL Model-JDBC Connection" from the list and hit "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject10.JPG
  1. Enter "MySQL Test" in the "Name" box.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject11.JPG
  1. We gotta define the driver now.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject12.JPG
  1. Select "5.0" and click on "Add".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject13.JPG
  1. Select MySQL -> 5.0 -> MySQL JDBC Driver.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject14.JPG
  1. Select the existing "Driver File" and remove it.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject15.JPG
  1. Hit "Add" to add a new driver based on your installation.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject16.JPG
  1. Select the driver jar from where you previously installed it on your system.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject17.JPG
  1. Update the parameters to reflect your settings.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject18.JPG
  1. Make sure you have the MySQL -> 5.0 -> MySQL JDBC Driver selected and click "OK".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject19.JPG
  1. Select "Save Password" and hit "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject20.JPG
  1. Verify the settings and click "Finish".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject21.JPG
  1. The "MySQL Test" connection you created should now show in the "Connection" drop-down as the current selection. Hit "Next".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject22.JPG
  1. Select "Server Supplied JSF Implementation" and hit "Next" again.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject23.JPG
  1. This is the reason you're doing this whole "New Seam Project" thing - you need to add a Seam runtime. Unless you go through this wizard, RHDS will throw an NPE that you can see in the 

&lt;workspace&gt;

\.metadata\.log and will fail to save the Seam Runtime configuration. So click "Add" here - the Wizard code works.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject24.JPG
  1. Enter "JBoss Seam 1.2 GA" and no other, and pick your base Seam 1.2 installation directory. Click "Finish".
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject25.JPG
  1. Pick "ear" from "Deploy as", MySQL as the "Database Type", "MySQL Test" from the "Connection profile" drop-down and worry not about changing the Code generation. Hit "Finish" and you're done with this wizard. _Note_ here: it's happened to me that the MySQL connection profile I created in an earlier step was not present in the drop-down, nor would it let me create another with the same name. What I did was cancel the whole wizard and start it again, only this time the JBoss Runtime, the Seam Runtime and the "MySQL Test" connection profile were already there.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject26.JPG
  1. Once you kill the "Welcome" window, you will see the newly-created projects in RHDS.
  1. http://www.geocities.com/m_poplacenel/Bundzilla/NewSeamProject27.JPG
  1. You may now delete them if you want, including or not the content - all we needed from these was the JBoss Runtime, Seam Runtime and MySQL Test configurations.

That's all! :D Now you can move forward to [Importing the Bundzilla projects into RHDS](ImportingBundzillaProjectsInRHDS.md).