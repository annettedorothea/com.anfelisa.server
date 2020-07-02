# com.anfelisa.server

This is the server for the anfelisa vocabulary trainer.

See [Anfelisa](https://anfelisa.de/#).

It is written with Java, is based on the [de.acegen](https://github.com/annettedorothea/de.acegen) 
DSL and code generator and uses Dropwizard as http server framework.

See [com.anfelisa.client](https://github.com/annettedorothea/com.anfelisa.client) for the client project.

## Installation

- Get latest Ecplise.
- Install the [de.acegen](https://github.com/annettedorothea/de.acegen) Ecplise plugin from [http://acegen.de](http://acegen.de).
- Maven install the project dependencies.
- Create a postgres database.
- Create a yml file like the [sample.yml](sample.yml).
- Run the migrations with `db migrate <your-yml-file>.yml` as argument.
- Start the application with the arguments `server <your-yml-file>.yml` as argument.

## License
[ISC](License.txt)
