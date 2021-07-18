@echo off
:select
set /p tool=Please, enter:1 CONSOLE 2 ANT else MAVEN

If /i "%tool%"=="1" (
   startConsole.bat
   cd../

) else (
    If /i "%tool%"=="2" (
        startAnt.bat
         cd ../../

    ) else (
         startMaven.bat
         cd ../

    )
)
