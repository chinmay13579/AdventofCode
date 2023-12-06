def find_top_three_calories(elves_input):
    # Create a list to store the Calories for each Elf
    elves_calories = []

    # Iterate through the input and calculate total Calories for each Elf
    current_cal = 0
    for line in elves_input:
        if line.strip():  # Check if the line is not empty
            current_cal += int(line)
        else:
            # Add the total Calories to the list for the current Elf
            elves_calories.append(current_cal)
            current_cal = 0  # Reset the current_calories for the next Elf

    # Add the total Calories for the last Elf
    elves_calories.append(current_cal)

    # Sort the list in descending order to find the top three Elves
    elves_calories.sort(reverse=True)

    # Calculate the sum of Calories for the top three Elves
    top_three_sum = sum(elves_calories[:3])

    return top_three_sum

def main():
    # Read input from a text file
    with open('input.txt', 'r') as file:
        lines = file.read().splitlines()

    # Find and print the result
    result = find_top_three_calories(lines)
    print("Total Calories carried by the top three Elves:", result)

if __name__ == "__main__":
    main()
