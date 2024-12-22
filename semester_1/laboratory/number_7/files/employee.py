class Employee:

    def __init__(self, name, id):
        self.name = name
        self.id = id

    def get_info(self):
        return f'Имя: {self.name}, ID: {self.id}'