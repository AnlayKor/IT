def print_file(name, lines=False):
    with open(name, 'r', encoding='utf-8') as file:
        if lines:
            for line in file:
                print(line.strip())
        else:
            content = file.read()
            print(content)


print_file('example.txt')
print()
print_file('example.txt', lines=True)