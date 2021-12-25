# My Retail - ProductDetails


myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. This is an end-to-end Proof-of-Concept for a products API, which will aggregate product data from Product Repository and Pricing Information from Pricing Repository and return it as a single JSON to the caller.

this represents Product Details CRUD microservice

Database: MongoDb - downaloadable here - https://www.mongodb.com/try/download/community 

Database Tools - Compass 

SpringBoot version - 2.7.0

MongoDB document / collection - pricingdb / productDetails

example data collection: {"_id":"123","item":{"productDescription":{"title":"The Big Lebowski (Blu-ray)","downstreamDescription":"Jeff \"The Dude\" Lebowski (Bridges) is the victim of mistaken identity. Thugs break into his apartment in the errant belief that they are accosting Jeff Lebowski, the eccentric millionaire philanthropist, not the laid-back, unemployed Jeff Lebowski. In the aftermath, \"The Dude\" seeks restitution from his wealthy namesake. He and his buddies (Goodman and Buscemi) are swept up in a kidnapping plot that quickly spins out of control."},"enrichment":{"images":{"primaryImageUrl":"https://target.scene7.com/is/image/Target/GUEST_bac49778-a5c7-4914-8fbe-96e9cd549450"}},"productClassification":{"productTypeName":"ELECTRONICS","merchandiseTypeName":"Movies"},"primaryBrand":{"name":"Universal Home Video"}}}

Running port - 5010


Running instructions: 

a. download mongodb. create database, collection and document as described above. 

b. git clone this repository and import it to eclipse or any IDE

c. run it as mvn spring boot. 
