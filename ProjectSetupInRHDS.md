# Introduction #

This describes the steps you need to take to configure Red Hat Developer Studio for Bundzilla development.

# Details #

## Installing the IDE ##

The first step for setting up the project in Red Hat Developer Studio (_RHDS_) is... well, _getting_ the IDE. That is, if you don't have it, and given that it's not `[`yet`]` one of the most ubiquitous IDEs in the market, you probably don't.

If the title hasn't gotten you concerned yet, now it's time you might be thinking about these:
  1. you don't know how to use it, and
  1. you may not be able to afford it.

Well,
  1. money is no problem - like most things from the boss of Java with a Red Hat, it's free;
  1. about how to use it, there's nothing I can do except from helping you learn it, but chances are that you've worked with Eclipse, in which case you're home: RHDS is nothing but a re-branded, vamped-up version of Eclipse. More features, and probably more bugs.

Now that you've started feeling relaxed again and lost `[`most of`]` the mutinous thoughts, here's where you get it from [here](http://www.redhat.com/developers/rhds/index.html). Note that it's version Beta 2, based on Eclipse Europa, and it's still buggy, especially in the SEAM part. The URL might change in the future, as they -hopefully- update with new Beta versions (or even the bug-free release one ;)), so feel free to google for it if our link gets out of sync.

## Installing the SVN plugin for RHDS ##
You will need the [SVN plugin](http://subclipse.tigris.org/) if you want to directly check in and update code from RHDS. Since RHDS is based on Eclipse 3.3 Europa, you will need version 1.2.4 or above. To install it, you will have to point RHDS to download it from http://subclipse.tigris.org/update_1.2.x.

## "Priming" RHDS for Seam ##
Due to a bug in the Seam support part of RHDS, you'll have to "prime" the IDE by creating a project with the wizard prior to importing the projects you checked out from Google Code with SVN. The full description can be found [here](PrimingRHDSForSeam.md).

You must follow the instructions in that page to be able to move any forward.