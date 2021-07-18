@echo off
:select
set /p tool=Please, enter:1 for graphical interface or 2 for console:
If /i "%tool%"=="1" (
    cd compileAndRunWindow
    STARTERgui.bat
    cd ../
) else (
    If /i "%tool%"=="2" (
        cd compileAndRunWindow
        STARTER.bat
         cd ../
    ) else (
        echo NOT 1 or 2 entered! Please ENTER
        echo 1 for graphical interface or 2 for console:
        goto select
    )
)






