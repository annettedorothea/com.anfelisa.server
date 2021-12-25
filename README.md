# com.anfelisa.server

This is the server for the anfelisa vocabulary trainer.

See [Anfelisa](https://anfelisa.de/#).

It is written with Java, is based on the [de.acegen](https://github.com/annettedorothea/de.acegen) 
DSL and code generator and uses Dropwizard as http server framework.

See [com.anfelisa.client](https://github.com/annettedorothea/com.anfelisa.client) for the client project.

## Installation

- Get latest Ecplise.
- Install the [de.acegen](https://github.com/annettedorothea/de.acegen) Ecplise plugin from [http://acegen.de](http://acegen.de).
- Maven install the project dependencies. (In order not to run the integration tests that need a running server in DEV mode comment the maven-surefire-plugin section from the [pom.xml](pom.xml))
- Create a postgres database.
- Create a yml file like [sample.yml](sample.yml).
- Run the migrations with `db migrate <your-yml-file>.yml` as argument. The main class is de.acegen.App.
- Start the application (de.acegen.App) with the arguments `server <your-yml-file>.yml` as argument.

## Integration tests

- To run the tests execute maven install or maven test or execute them from the IDE. They are located in src/test/java.

## Replay events

- In order to replay events you have to set writeTimeline in the yml file to ALWAYS to record a valid timeline.
- To replay the events execute the according dropwizard command with the arguments `replay <your-yml-file>.yml` for de.acegen.App. 

## License
[ISC](License.txt)
