# Football Transfer Market API

## Overview
This API is built with Spring Boot and utilizes data from the [Transfermarkt Datasets](https://github.com/dcaribou/transfermarkt-datasets?tab=readme-ov-file#%EF%B8%8F-frontends).

## Features

### Competition
- Retrieve competition by ID.
- Retrieve all competitions with filters for:
    - Competition name
    - Subtype
    - Type
    - Country name
    - Major national language
    - Paging and sorting

### Club
- Retrieve club by ID.
- Retrieve all clubs with filters for:
    - Club name
    - Squad size
    - Squad average age
    - Paging and sorting
- Retrieve club players.
- Retrieve club matches.

### Match
- Retrieve match lineup by ID.
- Retrieve match events by ID.

### Player
- Retrieve player by ID.
- Retrieve player appearances by ID.
- Retrieve all players with filters for:
    - Player name
    - Position
    - Height
    - Foot
    - Market value
    - Paging and sorting

### Transfer
- Retrieve all transfers with filters for:
    - Player ID
    - From club ID
    - To club ID
    - Paging and sorting

## To-Do
- Implement exception handling.
- Clean up code.
- Add Swagger documentation.
