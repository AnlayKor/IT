def print_file(name, lines=False):
    try:
        with open(name, 'r', encoding='utf-8') as file:
            if lines:
                for line in file:
                    print(line.strip())
            else:
                content = file.read()
                print(content)
    except FileNotFoundError:
        print('Файла с таким именем не существует')

print_file('example.txt')
print()
print_file('example.txt', lines=True)
print()
print_file('none.txt')