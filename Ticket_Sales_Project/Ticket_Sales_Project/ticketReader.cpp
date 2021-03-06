#include "ticketReader.h"
#include "helper.h"
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <vector>

using namespace std;

/*	TICKETREADER
/	written by	Ryan Morton - 100485285
/				Thomas Frantz - 100484424
/				Alvin Lee - 100484342
/
/	Manages the tickets information
*/


const int event_length = 25;
const int user_length = 15;
const int MAX_TICKETS_SELL = 100;
const int MAX_TICKET_PRICE = 1000;

// printTickets - an internal function that the user will never be able to call. Used to look at the data in the tickets vector

void ticketReader::printTickets(){
	for (int i = 0; i < tickets.size(); i++){
		cout << tickets[i];
		cout << endl;
	}
	cout << "\n";
}

// findEvent - an internal helper function used to find the location of an event in the tickets vector
// input : string event - the event name we are searching for
// return : index - index of the event in the tickets vector
//					-1 if that event can't be found

int ticketReader::findEvent(string event){
	int index = 0;
	for (index = 0; index < event.size(); index++){
		if (helper::pad(event, event_length, " ", false).compare(tickets[index].substr(0, event_length)) == 0)
			return index;
	}
	return -1;
}


// buy - allows tickets to be purchased
// input:	string event - the event that we wish to buy tickets for
//			int quantity - the amount of tickets being purchased
// return values for buy:
//  0 is success
// -1 is show not found
// -2 is not enough tickets remaining to complete transaction

int ticketReader::buy(string event, int quantity){
	int ticketIndex = findEvent(event);
	if (ticketIndex == tickets.size()){
		return -1;
	}
	int numAvailable = stoi(tickets[ticketIndex].substr(42, 3));
	if (numAvailable < quantity){
		return -2;
	}

	int numRemaining = numAvailable - quantity;
	string newEntry = tickets[ticketIndex].substr(0, 42);
	newEntry += helper::pad(to_string(numRemaining),3,"0",true);
	newEntry += tickets[ticketIndex].substr(45, 7);
	tickets[ticketIndex] = newEntry;
	return 0;
}


// sell - allows a user to post tickets for sale
// input:	string event - the event name the user is listing
//			double price - the cost of the event
//			int quantity - the number of tickets for sale
//			string user  - the seller of the tickets
//
// return: 
//  0 for success
// -1 for eventname too long
// -2 for invalid account type
// -3 for invalid price
// -4 for invalid quantity

int ticketReader::sell(string event, double price, int quantity, string user){
	if (event.length() > event_length){
		return -1;
	}
	//todo : permissions check

	if (price < 0 || price >= MAX_TICKET_PRICE){
		return -3;
	}
	if (quantity <= 0 || quantity > MAX_TICKETS_SELL){
		return -4;
	}
	tickets.push_back(helper::pad(event, event_length, " ", false) + " " + helper::pad(user, user_length, " ", false) + " " + helper::pad(to_string(quantity), 3, "0", true) + 
		" " + helper::pad(helper::dtom(price), 6, "0", true));
	return 0;
}

// read - reads in the available tickets information from file and puts it into the tickets vector
// return: 0 on success
//		  -1 on file open error

int ticketReader::read(){
	ifstream reader("ticketInfo.txt");
	string input;
	if (reader.is_open()){
		getline(reader, input);
		while (input.compare("END") != 0){
			tickets.push_back(input);
			getline(reader, input);
		}
		return 0;
	}
	else{
		cout << "Unable to open file";
		return -1;
	}
}

// getEvents - gives all the ticket information
// return: tickets - the tickets vector that contains all the ticket information

vector<string> ticketReader::getEvents(){
	return tickets;
}

/*int main(){
	ticketReader ticket;
	ticket.read();
	ticket.printTickets();
	ticket.buy("Blink 182", 3);
	ticket.printTickets();
	ticket.sell("Alvin and the Chipmunks", 11.75, 70, "jimmy");
	ticket.printTickets();
	return 0;
}*/