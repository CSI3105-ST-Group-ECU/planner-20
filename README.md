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
2. Right Click src, then click build path > use as source folder
3. Right click src, then click build path > configure output folder. Select default for me was target.
4. To add the jar files clone this repo: https://github.com/CSI3105-ST-Group-ECU/lib
5. Create a folder called lib
6. Select all the jar files and right click then click build path > add to build path
7. Now should be ready to run both the tests and main method

## Getting started with Intellij




## What they dont teach you at uni.... Git
Follow this guide and you be fine :D, some ide's have git but you can always download git bash for windows, however you can use https://git-fork.com/ which was recommended by my boss as its good for noobs like us.

```bash
    git clone https://github.com/CSI3105-ST-Group-ECU/planner-20.git
    git checkout -b your-branch-name    ## creat new branch and swap to it
    git branch                          ## list branches
    git status                          ## shows changes
    git add .                           ## add all changes     
    git commit -m "message here"        ## commits locally the changes
    git push origin your-branch-name    ## it will create new or add to exsiting
    ##Go to the repo in GitHub and create the pull request!    
```

For git refrence: https://www.git-scm.com/docs

## Make a pr so everyone can judge you :P

After pushing that code go to git to make pull request (pr):

1. Go to https://github.com/CSI3105-ST-Group-ECU/planner-20/pulls
2. Click on new pull request
3. In the compare drop down click and find the branch you want to merge
4. If its all good click on create pull request
5. There is no restrictions on master so anyone can push and merge

Jake: I am trying to do my first pull request lol ignore this :)
