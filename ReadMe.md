# Welcome to Itemized Bill Generation !

This program will take input and start processing for Bill generation.

Discount calculation criteria
If total bill > 100, then put flat 10% discount on total amount,
If total bill > 200 then 10% discount on 200 INR and 20% discount on the amount exceeding 200.


# Setup 
1. Checkout project to local machine
``sh
git clone https://github.com/sauravsingh29/ss-crest-test.git
``

2. Import Project into your favorite java IDE (Eclipse, intellij idea etc..) as Maven project.
3. Select root folder or project , right click -> run as Java Application
	Or
4. Run maven command
	``sh
	mvn clean install
	``
	then execute command ``bash java -jar ss-test-0.0.1-SNAPSHOT.jar`` from target folder.

