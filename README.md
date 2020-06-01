# Tambola
Intorduction
This project is an implementation of the popular party board game tambole/lotto/housie.

Getting Started

1. This project is built using gradle, so install gradle and ensure that gradle is in your path.
2. Use gradle eclipse, to generate the eclipse projects.
3. Use gradle build to run the tests and generate coverage

Known Issues
1. The build fails in travis with a PersistenceUnitLoadingException, need to fix that. The implementation so far uses an embedded derby-db, it appears that travis doesn't support that. Travis seems to support installed db's. So unfortunately no build passing badge and no code coverage badge until then :( Please reach out, if you can fix it.

Next Steps
1. I am looking to build REST API for this project. Contributions are welcome.
