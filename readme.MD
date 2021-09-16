# JPA Behaviour with transient fields in nested embedded objects

This project shows unexpected behaviour using hibernate to store/read an entity, that has nested embedded objects with transient fields.

It also compares the behaviour when replacing hibernate with EclipseLink.

The `main`-Branch uses hibernate, the `eclipse-link`-Branch uses EclipseLink.

The project contains a standalone-test, that can be executed. On the startup a complete h2-in-memory-database is automatically created by the jpa-provider and the test persists an entity. It is expected, that none of the transient values is stored in the database.

It is not a minimal project since it uses spring boot and provides different cases (working and failing).