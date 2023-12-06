def find_max_calories(elves_input):
    max_cal= 0
    current_cal = 0

    for line in elves_input:
        if line.strip():  # Check if the line is not empty
            current_cal += int(line)
        else:
            if current_cal > max_cal:
                max_cal = current_cal
            current_cal = 0  # Reset the current_calories for the next Elf

    # Check one last time in case the last Elf has the most Calories
    if current_cal > max_cal:
        max_cal = current_cal

    return max_cal

def main():
    # Read input from a text file
    with open('input.txt', 'r') as file:
        lines = file.read().splitlines()

    # Find and print the result
    result = find_max_calories(lines)
    print("Total Calories carried by the Elf with the most Calories:", result)

if __name__ == "__main__":
    main()
