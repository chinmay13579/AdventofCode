def calculate_score_from_file(file_path):
    total_score = 0

    with open(file_path, 'r') as file:
        strategy_guide = [line.strip() for line in file]

    for line in strategy_guide:
        opponent, response = line.split()
        score = 0

        if (opponent == 'A' and response == 'Y') or \
           (opponent == 'B' and response == 'X') or \
           (opponent == 'C' and response == 'Z'):
            # You win
            score = 8
        elif (opponent == 'A' and response == 'X') or \
             (opponent == 'B' and response == 'Z') or \
             (opponent == 'C' and response == 'Y'):
            # You lose
            score = 1
        else:
            # Draw
            score = 6

        total_score += score

    return total_score

# Example usage:
file_path = 'input2.txt'
result = calculate_score_from_file(file_path)
print(f"Total Score: {result}")
