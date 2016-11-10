@echo off

:INPUT
echo  c.ִ��clean����
echo  p.ִ��package����
echo  s.ִ������source�ļ�����
echo  e.ִ��eclipse����
echo  q.�˳�

echo ������Ҫѡ������
set /p cmd=
IF %cmd% == c GOTO CLEAN
IF %cmd% == p GOTO PACKAGE
IF %cmd% == s GOTO SOURCES
IF %cmd% == e GOTO ECLIPSE
IF %cmd% == a GOTO ASSEMBLY
IF %cmd% == q GOTO END

:ECLIPSE
call mvn eclipse:clean
call mvn eclipse:eclipse -U -DdownloadSources=true -DdownloadJavadocs=false
echo ============================================================================
echo =========================== eclipse is complete===============================
echo ============================================================================
GOTO INPUT

:CLEAN
call mvn eclipse:clean
call mvn clean
echo ============================================================================
echo =========================== clean is complete===============================
echo ============================================================================
GOTO INPUT

:PACKAGE
call mvn clean
call mvn -Dmaven.test.skip=true install

if exist %~dp0\target\weixin.war del %~dp0\target\weixin.war /q


rem cd deploy
rem call mvn assembly:assembly
rem cd ../bundle/war/target
rem if exist %~dp0\bundle\war\target\epoch.war del %~dp0\bundle\war\target\epoch.war /q
rem ren epoch  epoch.war 
rem cd %~dp0
echo ============================================================================
echo =========================== package is complete=============================
echo ============================================================================
GOTO INPUT


:SOURCES
mvn dependency:sources
echo ============================================================================
echo =========================== sources is complete=============================
echo ============================================================================
GOTO INPUT

:END
@pause

