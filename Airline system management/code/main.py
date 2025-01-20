#!/usr/bin/env python3
# ama_airlines.py

from random import randrange

# -------------------------------------------------------
# Dictionaries and Constants
# -------------------------------------------------------
airLineCompDict = {
    1: "QR", 2: "SQ", 3: "EK", 4: "CX", 5: "NH",
    6: "EY", 7: "LH", 8: "QF", 9: "HU", 10: "TG"
}

airlineWeightPrice = {
    "QR": 8, "SQ": 9, "EK": 12, "CX": 20, "NH": 10,
    "EY": 15, "LH": 13, "QF": 8, "HU": 5,  "TG": 6
}

classLux = {
    1: 2,      # first class
    2: 1.5,    # business class
    3: 1       # economy class
}

countryDestDict = {
    1: "Paris, France",       2: "Tokyo, Japan",       3: "Rome, Italy",
    4: "New York City, USA",  5: "Sydney, Australia",  6: "Cape Town, South Africa",
    7: "Kyoto, Japan",        8: "Barcelona, Spain",   9: "Machu Picchu, Peru",
    10: "Santorini, Greece"
}

depDateDict = {
    1: '1/1/2023',   2: '2/1/2023',   3: '3/1/2023',   4: '4/1/2023',
    5: '5/1/2023',   6: '6/1/2023',   7: '7/1/2023',   8: '8/1/2023',
    9: '9/1/2023',   10: '10/1/2023', 11: '11/1/2023', 12: '12/1/2023',
    13: '13/1/2023', 14: '14/1/2023', 15: '15/1/2023', 16: '16/1/2023',
    17: '17/1/2023', 18: '18/1/2023', 19: '19/1/2023', 20: '20/1/2023',
    21: '21/1/2023', 22: '22/1/2023', 23: '23/1/2023', 24: '24/1/2023',
    25: '25/1/2023', 26: '26/1/2023', 27: '27/1/2023', 28: '28/1/2023',
    29: '29/1/2023', 30: '1/2/2023'
}

arrDateDict = {
    1: '1/1/2023',   2: '2/1/2023',   3: '3/1/2023',   4: '4/1/2023',
    5: '5/1/2023',   6: '6/1/2023',   7: '7/1/2023',   8: '8/1/2023',
    9: '9/1/2023',   10: '10/1/2023', 11: '11/1/2023', 12: '12/1/2023',
    13: '13/1/2023', 14: '14/1/2023', 15: '15/1/2023', 16: '16/1/2023',
    17: '17/1/2023', 18: '18/1/2023', 19: '19/1/2023', 20: '20/1/2023',
    21: '21/1/2023', 22: '22/1/2023', 23: '23/1/2023', 24: '24/1/2023',
    25: '25/1/2023', 26: '26/1/2023', 27: '27/1/2023', 28: '28/1/2023',
    29: '29/1/2023', 30: '1/2/2023'
}

classDict = {
    1: "first class",
    2: "business class",
    3: "economic class"
}

# -------------------------------------------------------
# Helper to parse a date string "day/month/year" into (day, month, year)
# -------------------------------------------------------
def parse_date(date_str):
    parts = date_str.split('/')
    if len(parts) != 3:
        return 0, 0, 0
    day = int(parts[0])
    month = int(parts[1])
    year = int(parts[2])
    return day, month, year

# -------------------------------------------------------
# Boarding Pass Function
# -------------------------------------------------------
def boardingPass(
    seat_class, adults, children, infants,
    destination, departureDay, departureMonth, departureYear,
    airline, returnDay=0, returnMonth=0, returnYear=0
):
    """
    Prints a simplistic boarding pass. 
    Offers a seat selection mode (random/manual).
    """
    choice = int(input("Seat selection:\n1. Manual\n2. Random\nEnter your choice: "))
    rows = 40
    columns = 6
    if choice == 1:
        # Manual seat selection process (placeholder)
        pass
    elif choice == 2:
        # Random seat selection process (placeholder)
        pass
    else:
        print("Invalid choice.")

    # Printing the boarding pass header
    print("\nBoarding Pass:")
    print(
        "+--------------+-----------------+--------------+--------------+--------------+----------------------+----------------------+----------------------+------------+"
    )
    print(
        "| Seat Number  |   Seat Class    |    Adults    |   Children   |   Infants    |      Destination     |   Date Departure    |    Date Arrival     |  Airline   |"
    )
    print(
        "+--------------+-----------------+--------------+--------------+--------------+----------------------+----------------------+----------------------+------------+"
    )

    # Printing details for each passenger
    for i in range(adults + children + infants):
        seat_number = None  # Placeholder for the seat number
        seat_type   = classDict.get(seat_class, "economic class")

        if i < adults:
            passenger_type = "Adult"
        elif i < (adults + children):
            passenger_type = "Child"
        else:
            passenger_type = "Infant"

        # The display in the table for child/infant is kept as a placeholder
        child_text   = "---" if passenger_type != "Child" else "Child"
        infant_text  = "---" if passenger_type != "Infant" else "Infant"

        print(
            "| %12s | %14s | %12s | %12s | %12s | %20s | %5s/%-5s/%-4s | %5s/%-5s/%-4s | %10s |"
            % (
                seat_number, seat_type,
                passenger_type,
                child_text,
                infant_text,
                destination,
                departureDay, departureMonth, departureYear,
                returnDay if returnDay != 0 else "--",
                returnMonth if returnMonth != 0 else "--",
                returnYear if returnYear != 0 else "----",
                airline
            )
        )

    print(
        "+--------------+-----------------+--------------+--------------+--------------+----------------------+----------------------+----------------------+------------+"
    )

# -------------------------------------------------------
# Filter or No Filter Prompt
# -------------------------------------------------------
def filterChoice():
    print("Do you want your suggestions to be filtered?")
    choice1 = int(input("1- Yes\n2- No\nEnter your choice: "))
    return choice1

# -------------------------------------------------------
# NO FILTER: Display random flights, let the user pick
# -------------------------------------------------------
def nofilter():
    """
    Returns a tuple:
    (
      flightType,
      numberOfAdults,
      numberOfChildren,
      numberOfInfants,
      classType,
      promo,
      departureDay, departureMonth, departureYear,
      returnDay, returnMonth, returnYear,
      airline,
      destination
    )
    """
    print("\n*** NO FILTER SUGGESTIONS ***")
    country = input("Enter the country you're in: ")

    print("\nOne-Way:")
    print("   %-11s%-10s%-29s%-20s" % ("Airline", "Origin", "Destination", "Departure"))
    one_way_list = []
    for i in range(10):
        arln = randrange(1, 11)
        depDate = randrange(1, 14)
        cntdest = randrange(1, 11)

        airline_name = airLineCompDict[arln]
        destination_name = countryDestDict[cntdest]
        d_day, d_month, d_year = parse_date(depDateDict[depDate])

        one_way_list.append((airline_name, destination_name, d_day, d_month, d_year))

        print(
            "%2d- %-10s %-10s %-25s from %s"
            % (
                i + 1,
                airline_name,
                country,
                destination_name,
                depDateDict[depDate]
            )
        )

    print("\nRound-Trip:")
    print("   %-11s%-10s%-29s%-20s%-17s" % ("Airline", "Origin", "Destination", "Departure", "Arrival"))
    round_trip_list = []
    for i in range(10):
        arln = randrange(1, 11)
        depDate = randrange(1, 14)
        arrDate = randrange(14, 31)
        cntdest = randrange(1, 11)

        airline_name = airLineCompDict[arln]
        destination_name = countryDestDict[cntdest]
        d_day, d_month, d_year = parse_date(depDateDict[depDate])
        r_day, r_month, r_year = parse_date(arrDateDict[arrDate])

        round_trip_list.append((airline_name, destination_name, d_day, d_month, d_year, r_day, r_month, r_year))

        print(
            "%2d- %-10s %-10s %-25s from %s to %s"
            % (
                i + 1,
                airline_name,
                country,
                destination_name,
                depDateDict[depDate],
                arrDateDict[arrDate]
            )
        )

    print("\nMulti-cities:")
    print("   %-11s%-10s%-25s%-30s%-25s%-25s%-17s"
          % ("Airline","Origin","Destination1","Destination2", "Departure1", "Departure2","(No final return)"))
    multi_city_list = []
    for i in range(10):
        arln = randrange(1, 11)
        depDate = randrange(1, 14)
        arrDate = randrange(14, 20)
        arrDate2 = randrange(20, 31)
        dest1 = randrange(1, 6)
        dest2 = randrange(6, 11)

        airline_name = airLineCompDict[arln]
        destination_name1 = countryDestDict[dest1]
        destination_name2 = countryDestDict[dest2]

        d_day1, d_month1, d_year1 = parse_date(depDateDict[depDate])
        d_day2, d_month2, d_year2 = parse_date(arrDateDict[arrDate])
        d_day3, d_month3, d_year3 = parse_date(arrDateDict[arrDate2])

        multi_city_list.append(
            (
                airline_name,
                destination_name1, destination_name2,
                d_day1, d_month1, d_year1,
                d_day2, d_month2, d_year2,
                d_day3, d_month3, d_year3
            )
        )

        print(
            "%2d- %-10s %-10s %-25s %-25s from %s till %s till %s"
            % (
                i + 1,
                airline_name,
                country,
                destination_name1,
                destination_name2,
                depDateDict[depDate],
                arrDateDict[arrDate],
                arrDateDict[arrDate2]
            )
        )

    print("\nChoose which type of flight you want:")
    print("1. One-Way\n2. Round-Trip\n3. Multi-cities")
    flightType = int(input("Enter your choice (1/2/3): "))

    place = int(input("Enter the number of the flight (1..10) you want to book: "))
    while place < 1 or place > 10:
        place = int(input("Invalid. Enter the number of the flight (1..10) you want to book: "))

    choiceAdults = int(input("How many adults onboard? (+12 years old)\n"))
    choiceChildren = int(input("How many children onboard? (2-12 years old)\n"))
    choiceInfants = int(input("How many infants onboard? (0-23 months)\n"))

    choiceClass = int(input(
        "Please choose one of the classes below:\n"
        "1- First class\n"
        "2- Business class\n"
        "3- Economy class\n"
    ))
    choicePromo = input("Enter the promo code if you have any (otherwise press Enter)\n")

    # Defaults
    departureDay = departureMonth = departureYear = 0
    returnDay = returnMonth = returnYear = 0
    airline_chosen = ""
    destination = ""

    if flightType == 1:
        (airline_chosen,
         destination,
         departureDay, departureMonth, departureYear) = one_way_list[place - 1]

    elif flightType == 2:
        (airline_chosen,
         destination,
         departureDay, departureMonth, departureYear,
         returnDay, returnMonth, returnYear) = round_trip_list[place - 1]

    else:  # Multi-cities
        multi_data = multi_city_list[place - 1]
        airline_chosen = multi_data[0]
        destination = multi_data[1] + " & " + multi_data[2]
        departureDay, departureMonth, departureYear = multi_data[3], multi_data[4], multi_data[5]
        # no final return date here

    return (
        flightType,
        choiceAdults,
        choiceChildren,
        choiceInfants,
        choiceClass,
        choicePromo,
        departureDay,
        departureMonth,
        departureYear,
        returnDay,
        returnMonth,
        returnYear,
        airline_chosen,
        destination
    )

# -------------------------------------------------------
# FILTER: user chooses flight type
# -------------------------------------------------------
def flightModeFiltering():
    choiceMode = int(input(
        "Hello! What type of flight do you want?\n"
        "1 - Departure only\n"
        "2 - Departure and return\n"
        "3 - Adventure mode (multiple flights)\n"
        "Enter your choice (1/2/3): "
    ))
    return choiceMode

def filtering(choiceMode):
    """
    Returns different sets of data depending on the flight mode chosen:
      flightMode = 1:
        (adults, children, infants, class, promo, dep_day, dep_month, dep_year, airline, destination)
      flightMode = 2:
        (adults, children, infants, class, promo, dep_day, dep_month, dep_year,
         return_day, return_month, return_year, destination, airline)
      flightMode = 3:
        (adults, children, infants, class, promo, stops, listDestinations, listDates)
    """
    choiceAdults = int(input("How many adults onboard? (+12 years old)\n"))
    choiceChildren = int(input("How many children onboard? (2-12 years old)\n"))
    choiceInfants = int(input("How many infants onboard? (0-23 months)?\n"))

    choiceClass = int(input(
        "Please choose one of the classes below:\n"
        "1- First class\n"
        "2- Business class\n"
        "3- Economy class\n"
    ))
    choicePromo = input("Enter the promo code if you have any (otherwise press Enter)\n")

    if choiceMode == 1:
        # One-way
        choiceDepartureDay = int(input("Enter the departure day (number): "))
        choiceDepartureMonth = int(input("Enter the departure month (number): "))
        choiceDepartureYear = int(input("Enter the departure year (number): "))

        print("\nAvailable destinations:")
        for i, j in countryDestDict.items():
            print(i, j)
        choiceDestination = int(input("Please choose your destination by its number: "))

        print("\nSome random airline suggestions:")
        airline_list = []
        for i in range(5):
            arln = randrange(1, 11)
            random_airline = airLineCompDict[arln]
            airline_list.append(random_airline)
            print(
                "%d) %s -> Destination: %s on %d/%d/%d"
                % (
                    i + 1,
                    random_airline,
                    countryDestDict[choiceDestination],
                    choiceDepartureDay, choiceDepartureMonth, choiceDepartureYear
                )
            )

        choiceAirLine = int(input("Please enter which airline (1..5) you want to choose: "))
        while not (1 <= choiceAirLine <= 5):
            choiceAirLine = int(input("Invalid. Please choose (1..5): "))
        airline_chosen = airline_list[choiceAirLine - 1]

        return (
            choiceAdults,
            choiceChildren,
            choiceInfants,
            choiceClass,
            choicePromo,
            choiceDepartureDay,
            choiceDepartureMonth,
            choiceDepartureYear,
            airline_chosen,
            countryDestDict[choiceDestination]
        )

    elif choiceMode == 2:
        # Round-trip
        def valid_date_input(label):
            year = int(input(f"Enter the {label} year (number): "))
            month = int(input(f"Enter the {label} month (number): "))
            day = int(input(f"Enter the {label} day (number): "))
            return day, month, year

        print("\n--- Departure Date ---")
        dep_day, dep_month, dep_year = valid_date_input("departure")

        print("\n--- Return Date ---")
        ret_day, ret_month, ret_year = valid_date_input("return")

        while (dep_year * 10000 + dep_month * 100 + dep_day) > (ret_year * 10000 + ret_month * 100 + ret_day):
            print("Return date must be after the departure date. Please re-enter.")
            print("\n--- Departure Date ---")
            dep_day, dep_month, dep_year = valid_date_input("departure")
            print("\n--- Return Date ---")
            ret_day, ret_month, ret_year = valid_date_input("return")

        print("\nAvailable destinations:")
        for i, j in countryDestDict.items():
            print(i, j)
        choiceDestination = int(input("Please choose your destination by its number: "))

        print("\nSome random airline suggestions (round-trip):")
        airline_list = []
        for i in range(5):
            arln = randrange(1, 11)
            random_airline = airLineCompDict[arln]
            airline_list.append(random_airline)
            print(
                "%d) %s -> Destination: %s from %d/%d/%d to %d/%d/%d"
                % (
                    i + 1,
                    random_airline,
                    countryDestDict[choiceDestination],
                    dep_day, dep_month, dep_year,
                    ret_day, ret_month, ret_year
                )
            )

        choiceAirLine = int(input("Please enter which airline (1..5) you want to choose: "))
        while not (1 <= choiceAirLine <= 5):
            choiceAirLine = int(input("Invalid. Please choose (1..5): "))
        airline_chosen = airline_list[choiceAirLine - 1]

        return (
            choiceAdults,
            choiceChildren,
            choiceInfants,
            choiceClass,
            choicePromo,
            dep_day,
            dep_month,
            dep_year,
            ret_day,
            ret_month,
            ret_year,
            countryDestDict[choiceDestination],
            airline_chosen
        )

    else:
        # Multi-cities
        choiceStops = int(input("How many stops do you want to make? "))
        listDestinations = []
        listDates = []

        for i in range(choiceStops):
            print(f"\nAvailable destinations for stop #{i + 1}:")
            for key, val in countryDestDict.items():
                print(key, val)

            choiceDest = int(input("Please choose the destination (by number): "))
            dest = countryDestDict.get(choiceDest, "Unknown")
            listDestinations.append(dest)

            print(f"Enter the departure date for stop #{i + 1}: ")
            day = int(input("Day: "))
            month = int(input("Month: "))
            year = int(input("Year: "))

            if i > 0:
                prev_day, prev_month, prev_year = listDates[-1]
                while (prev_year * 10000 + prev_month * 100 + prev_day) > (year * 10000 + month * 100 + day):
                    print("Date must not be before the previous stop's date. Re-enter.")
                    day = int(input("Day: "))
                    month = int(input("Month: "))
                    year = int(input("Year: "))

            listDates.append((day, month, year))

        airline_chosen = "MultiCityFilter"
        return (
            choiceAdults,
            choiceChildren,
            choiceInfants,
            choiceClass,
            choicePromo,
            choiceStops,
            listDestinations,
            listDates
        )

# -------------------------------------------------------
# Main flow
# -------------------------------------------------------
def main():
    print("\t\t\tWELCOME ABOARD AMA AIRLINES")
    print("Please fill the following data:")
    full_name = input("FULL NAME: ")
    nationality = input("NATIONALITY: ")
    birthdate = input("DATE OF BIRTH (DD/MM/YY): ")
    email = input("EMAIL: ")
    phone_number = input("PHONE NUMBER: ")

    choiceF = filterChoice()

    flightType = 0
    numberOfAdults = 0
    numberOfChildren = 0
    numberOfInfants = 0
    classType = 3
    promo = ""
    departureDay = departureMonth = departureYear = 0
    returnDay = returnMonth = returnYear = 0
    airline = None
    destination = ""

    if choiceF == 2:
        # NO FILTER path
        (
            flightType,
            numberOfAdults,
            numberOfChildren,
            numberOfInfants,
            classType,
            promo,
            departureDay,
            departureMonth,
            departureYear,
            returnDay,
            returnMonth,
            returnYear,
            airline,
            destination
        ) = nofilter()

    else:
        # FILTER path
        flightType = flightModeFiltering()

        if flightType == 1:
            (
                numberOfAdults,
                numberOfChildren,
                numberOfInfants,
                classType,
                promo,
                departureDay,
                departureMonth,
                departureYear,
                airline,
                destination
            ) = filtering(flightType)

        elif flightType == 2:
            (
                numberOfAdults,
                numberOfChildren,
                numberOfInfants,
                classType,
                promo,
                departureDay,
                departureMonth,
                departureYear,
                returnDay,
                returnMonth,
                returnYear,
                destination,
                airline
            ) = filtering(flightType)

        else:
            # Multi-cities in the filter path
            multi_result = filtering(flightType)
            # multi_result -> (adults, children, infants, class, promo, stops, listDestinations, listDates)
            numberOfAdults, numberOfChildren, numberOfInfants, classType, promo, stops, listDestinations, listDates = multi_result
            airline = "MultiCityFilter"
            destination = " - ".join(listDestinations)
            if listDates:
                departureDay, departureMonth, departureYear = listDates[0]
            returnDay = returnMonth = returnYear = 0

    # -------------------------------------------------------
    # Baggage / Weight Calculation
    # -------------------------------------------------------
    if airline is None:
        airline = "Unknown"

    maxWeight = numberOfAdults * 25 + numberOfChildren * 15 + numberOfInfants * 10
    maxWeight *= classLux.get(classType, 1)
    print("\nYour total allowed weight is:", maxWeight, "Kg")
    print(
        "The adult can have a baggage of 25Kg, the children can have a baggage of 15Kg, "
        "the infant can have a baggage of 10Kg."
    )
    print(
        f"NOTE that if there is excess weight in luggage weight (total), "
        f"you will have to pay {airlineWeightPrice.get(airline, 7)}$ per Kg (airline: {airline})."
    )

    totalWeight = 0
    for _ in range(numberOfAdults):
        totalWeight += randrange(25, 30)
    for _ in range(numberOfChildren):
        totalWeight += randrange(15, 20)
    for _ in range(numberOfInfants):
        totalWeight += randrange(10, 12)

    print(f"Your total baggage weight is {totalWeight} Kg.")
    if maxWeight < totalWeight:
        diff = totalWeight - maxWeight
        print(f"It surpasses the allowed weight by {diff} Kg.")
        print(
            "You have to pay an extra %4d$"
            % (diff * airlineWeightPrice.get(airline, 7))
        )

    # -------------------------------------------------------
    # Boarding Pass
    # -------------------------------------------------------
    if flightType == 1:
        boardingPass(
            classType,
            numberOfAdults,
            numberOfChildren,
            numberOfInfants,
            destination,
            departureDay,
            departureMonth,
            departureYear,
            airline
        )
    elif flightType == 2:
        boardingPass(
            classType,
            numberOfAdults,
            numberOfChildren,
            numberOfInfants,
            destination,
            departureDay,
            departureMonth,
            departureYear,
            airline,
            returnDay,
            returnMonth,
            returnYear
        )
    else:
        # Multi-cities case: we just show one pass for the first flight
        boardingPass(
            classType,
            numberOfAdults,
            numberOfChildren,
            numberOfInfants,
            destination,
            departureDay,
            departureMonth,
            departureYear,
            airline
        )

    print("\nThank you for booking with AMA Airlines!")

# -------------------------------------------------------
# Run if main
# -------------------------------------------------------
if __name__ == "__main__":
    main()
