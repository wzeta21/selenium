echo "Running Container: Automation"
gradle -version
java -version
echo "Executing Automation Test"
cd /tmp/selenium/
echo "gradle clean test --tests $NAME_TEST"
gradle clean test --tests $NAME_TEST
echo "test completed"