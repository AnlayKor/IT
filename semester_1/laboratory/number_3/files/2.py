with open('user_input.txt', 'a+', encoding='utf-8') as file:
	file.write(input('Введите текст для записи в файл:'))
	print(file.read())