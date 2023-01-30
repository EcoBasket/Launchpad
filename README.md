# EcoBasket

<p align="center">
  <img
    src="https://imgur.com/TmOT1rU.png"
    width="50%"
  />
</p>

## Introduction

We won Best Overall at Launchpad 5.0 (2021)! :rocket:

Launchpad is a 24-hour hackathon organized by Bath Entrepreneurs, where cross-disciplinary teams compete to conceive and launch a business based on a given prompt. This years’ prompt was “Make a better future for humanity”.

The development team consisted of [Sergios](https://github.com/sg2295) and [Luke](https://github.com/lc2232) working on a React-Native frontend, [myself](https://github.com/OllieJonas) working on a backend written in Java Spring, hosted using tools from AWS, and [Alex](https://github.com/ll1) working on both frontend and backend.

We also had [Andy](https://www.linkedin.com/in/andrew-barton-000/) and [Lukas](https://www.linkedin.com/in/lukas-moment/) working on a business plan and presenting the idea. We aim to provide a new way to promote sustainability and work toward a better future, through EcoBasket!

EcoBasket helps address the problem of food-related environmental pollution, by calculating a Carbon Emission Score for food items sold in supermarkets, as well as providing better alternatives, to promote environmentally conscious shopping decisions.

As part of being one of the winner's of Launchpad, we were invited to particpate in [acceler8](https://uk.linkedin.com/company/acceler8bybe), an 8 week startup accelerator.

This project was also featured in an article! See [here](https://www.maddyness.com/uk/2021/04/01/meet-the-students-who-started-businesses-during-covid-19/)

## Solution

This is a relatively simple Java Spring CRUD solution. There are alot of bad coding practises in this project (we started working on this around 12 hours into the hackathon, and kept going throughout the night).  Specific food items were hard-coded to work for demonstration purposes. Results from endpoints are returned in JSON format using REST.

Carbon Emission scores are hard-coded, with values coming from [here](https://ourworldindata.org/grapher/ghg-per-kg-poore) (simply used as a proof-of-concept, we didn't really have time to do anything better).

Leaderboards are calculated by finding a user's friends, getting their scores and ordering them (re-calculated each time).

This project relies heavily on AWS services. Namely, it uses Elastic Beanstalk for hosting the project, DynamoDB for storing user data and friends, and CodePipeline for a simple CI/CD pipeline.

## Prototype

Designed in Figma, we came up with a prototype for our proposed solution, which can be seen below:

![EcoBasket Prototype #1](/images/ecobasket-prototype-1.png)


