PUSHD accountsexist
call test.bat
POPD

PUSHD accountType1
call test.bat
POPD

PUSHD accountType4
call test.bat
POPD


PUSHD credit1000
call test.bat
POPD

PUSHD credit
call test.bat
POPD

PUSHD sellerhascredit
call test.bat
POPD

PUSHD GenericSpecificTest
call test.bat
POPD

PUSHD maxTickets
call test.bat
POPD

PUSHD noshow
call test.bat
POPD


PUSHD GenericSpecificTest2
call test.bat
POPD


PUSHD user1
call test.bat
POPD


PUSHD adminCreate
call test.bat
POPD

PUSHD uniqueUser
call test.bat
POPD

PUSHD userType
call test.bat
POPD


PUSHD deletable
call test.bat
POPD

PUSHD currentaccount
call test.bat
POPD

PUSHD refundable
call test.bat
POPD

PUSHD userNotExist
call test.bat
POPD

PUSHD sellable
call test.bat
POPD

PUSHD sellMax
call test.bat
POPD

PUSHD titleMax
call test.bat
POPD

PUSHD numberMax
call test.bat
POPD

PUSHD Testshow1
call test.bat
POPD

PUSHD accountType3
call test.bat
POPD

type reportDirectories.txt | masterReportWriter.exe

