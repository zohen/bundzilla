# Introduction #

Let's say you've heard of this project and you're so thrilled about it, that you want to immediately jump in and help us with its development. Now the question is: how do you setup your development environment to be as productive as any other of its old-timers?

Well, good question, and better yet, you came to the right place with it. This document is supposed to provide you with its ultimate answer.

# Details #

## Installing the JDK ##
You should download and install the most recent JDK from http://java.sun.com. We're currently using 1.5.0\_11, so you will see references to that particular version further down in the document; that does not mean it's the only supported one, other 1.5.0 minor releases are probably working/going to work with no problems, although it'll be up to you to verify :D. So if you're going to use another version, please substitute the references to our version with what's appropriate for your actual installation.

## Installing and configuring MySQL ##
Next, you need to install a [MySQL](http://www.mysql.com/) Community Server with InnoDb engine on your machine. You can download the kit from [here](http://dev.mysql.com/downloads/mysql/5.0.html#win32). Pick the "Windows Essentials (x86)" (22.9M).

You will also need the [JDBC driver](http://www.mysql.com/products/connector/j/) (the 5.0 version). You can find it in [here](http://dev.mysql.com/downloads/connector/j/5.0.html). Just unzip it to a folder of your choice.

## Installing JBoss ##
You need to download [JBoss](http://jboss.org) from [here](http://labs.jboss.com/jbossas/downloads/) and install it. We are using the [4.2.1 GA](http://labs.jboss.com/downloading/?projectId=jbossas&url=http://sourceforge.net/project/showfiles.php?group_id=22866&package_id=16942&release_id=523619) version, and I put it in JProgramFiles so its root directory in my examples will be C:\JProgramFiles\jboss-4.2.1.GA further down in the document.

  * ote**: you don't need to run it for now - just to unzip the downloaded archive.**

## Downloading SVN ##
In order to get the sources, you need the version control client for SVN. I recommend you the command line one, although if you're an "advanced" user, you may feel free to try with any other client of your choice. **Remember** though: if you try with another command line client, you're on your own!

The SVN home page is http://subversion.tigris.org/. You get the SVN command line from [the downloads page](http://subversion.tigris.org/servlets/ProjectDocumentList?folderID=8100&expandFolder=8100&folderID=8100); the one I recommend using is [svn-win32-1.4.5.zip](http://subversion.tigris.org/downloads/1.4.5-win32/apache-2.2/svn-win32-1.4.5.zip). Unzip it in a folder for now - next you will learn how to put the executable in your path. I will assume you unzipped the archive to c:\JProgramFiles in the following sections.

## Preparing the setEnv batch file ##
While you can modify the necessary variables in your global environment, I will recommend you to use a file you source in a command window before starting to work on Bundzilla. This eliminates the side-effects you might have by using environment entries modified by programs installed later on your machine, or, why not, the ones meant for Bundzilla _with_ programs installed _previously_ on your machine.

### Creating the batch file ###
In order for your svn client to be accessible to your shell/command windows, you will have to include its parent directory in the Operating System's path. I will give you here the instructions for MS Windows - I trust you will understand what needs to be done if you're planning to develop on a Linux/Unix system.

With a pure-text editor of your choice (Notepad, Vi, Emacs) create a file named setEnv.cmd and place it in an easily-accessible folder (e.g. right under C:\). In the editor, add the following:
```
 title Bundzilla
 set JAVA_HOME=c:\Program Files\Java\jdk1.5.0_11
 path %PATH%;C:\JProgramFiles\svn-win32-1.4.5\bin;%JAVA_HOME%\bin
 set CLASSPATH=
 set BUNDZILLA_HOME=C:\home\mihai\work\Bundzilla
```
Remember to substitute `C:\JProgramFiles\svn-win32-1.4.5` with the actual path to where you unzipped the downloaded svn client file.

### Sourcing the batch file ###
Open a command window and source the file:
```
C:\Windows> C:\setEnv.cmd
```

### Testing your svn client ###
In the same window, check your client is accessible by typing:
```
C:\Windows> svn --version
svn, version 1.4.5 (r25188)
   compiled Aug 22 2007, 20:56:15

Copyright (C) 2000-2006 CollabNet.
Subversion is open source software, see http://subversion.tigris.org/
This product includes software developed by CollabNet (http://www.Collab.Net/).
...
```

## Checking out the code from SVN ##

Once you've installed RHDS, you can move on to downloading the project. If you're reading this page, you probably know already where to get it from. Just in case you don't, here are the [instructions](http://code.google.com/p/bundzilla/source). From now on, we'll assume you've checked out the project sources to your local folder `C:\bundzilla`.

## Building from the command line ##
You must be able to build the project from the command line, and you should do it every time right before you want to check in some changes. [Here](BuildFromCommandLine.md) is how to do it.

## Setting up your IDE ##
While nobody can force you to use an IDE or another, we strongly recommend you Red Hat Developer Studio Beta 2, since it's based on Eclipse 3.3 (Europa) and it has full support for Seam, RichFaces, Ajax4JSF and all the JBoss goodies (same company, eh?). [Here](ProjectSetupInRHDS.md)'s what you need to do to configure it for a seamless SEAMfull development with it.