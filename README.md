# Planner-20
Repo for software testing

## Dependencies

1. To set path for java 1.8 https://explainjava.com/java-path/
2. Will need those jar files for Junit 5 and Mockito 

## Running in console or terminal
Step 1) Clone repo using your favorite git client  
Step 2) Open console or terminal and cd to repo directory  
Step 3) type in either: 

    run.sh 
    run.bat

## Getting Started with Eclipse

1. Import repo into Eclipse (may need to do the following )
![Step 1](/scratch/images/e1.PNG "Step 1")
![Step 1](/scratch/images/e1a.PNG "Step 1")
2. Right Click src, then click build path > use as source folder
![Step 2](/scratch/images/e2.PNG "Step 2")
3. Right click src, then click build path > configure output folder. Select default for me was target. Also, Do the same for test folder.
![Step 3](/scratch/images/e3.PNG "Step 3")
4. To add the jar files clone this repo: https://github.com/CSI3105-ST-Group-ECU/lib
5. Copy all the jars into planner-20/lib folder
![Step 5](/scratch/images/e5.PNG "Step 5")
6. Select all the jar files and right click then click build path > add to build path
7. Now should be ready to run both the tests and main method
![Step 7](/scratch/images/e7.PNG "Step 7")

## Getting started with Intellij

1. Import project into Intellij
2. Do steps 4 and 5 above as in eclipse
3. Go to File > Project Structure
4. Specify project sdk, and compiler output directory e.g. bin
![Step 3 + 4](/scratch/images/j3.PNG "Step 3 and 4")
5. Next, go to modules select src as sources (blue) and the test folder as test (green)
![Step 5](/scratch/images/j5.PNG "Step 5")
6. then click on libraries > '+' button > java then nav to folder with libs highlight all the jars in lib folder and add.
![Step 6](/scratch/images/j6.PNG "Step 6")
7. Next setup configs for run for planner select main class for tests select Junit and select all in package
![Step 7](/scratch/images/j7.PNG "Step 7")
![Step 7](/scratch/images/j7a.PNG "Step 7")
8. Now should be ready to run both the tests and main method
![Step 8](/scratch/images/j8.PNG "Step 8")

## What they dont teach you at uni.... Git
Follow this guide and you be fine :D, some ide's have git but you can always download git bash for windows, however you can use https://git-fork.com/ which was recommended by my boss as its good for noobs like us.

```bash
    git clone https://github.com/CSI3105-ST-Group-ECU/planner-20.git
    ## Make sure your branch name IS NOT master or develop
    git checkout -b your-branch-name    ## create new branch and swap to it
    git branch                          ## list branches
    git status                          ## shows changes
    git add .                           ## add all changes     
    git commit -m "message here"        ## commits locally the changes
    git push origin your-branch-name    ## it will create new or add to existing
    ##Go to the repo in GitHub and create the pull request!    
```

For git reference: https://www.git-scm.com/docs

## Make a pr so everyone can judge you :P

After pushing that code go to git to make pull request (pr):

1. Go to https://github.com/CSI3105-ST-Group-ECU/planner-20/pulls
2. Click on new pull request
3. In the compare drop down click and find the branch you want to merge
4. If its all good click on create pull request
5. There is no restrictions on master so anyone can push and merge

Jake: I am trying to do my first pull request lol ignore this :)
