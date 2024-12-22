class Book:
    title = 'Persona 5 Royal'
    author = 'Atlus'
    year = 2020

    def get_info(self):
        return f"Название книги: {self.title}, Автор: {self.author}, Год издания: {self.year}"


book = Book()
print(book.get_info())