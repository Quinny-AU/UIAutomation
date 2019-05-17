# UIAutomation

#Run Command for all Test, "browser" replaced with chrome or firefox for desired browser testing
mvn test -Dbrowser="browser"

#Run Command for specific Tests
#"browser" replaced with chrome or firefox for desired browser testing
#'tag' replaced with tag assigned to Test specific or set of Test scenarios
mvn test -Cbrowser="browser" -Dcucumber.options="--tags @'tag'"
