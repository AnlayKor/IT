from employee import Employee


class Manager(Employee):
    def __init__(self, name, id, department=''):
        super().__init__(name, id)
        self.department = department

    def get_info(self):
        return f'{super().get_info()}, менеджер отдела {self.department}'

    def manage_project(self):
        return f'Управляет проектами в отделе {self.department}'
