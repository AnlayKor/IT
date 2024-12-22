from manager import Manager
from technician import Technician


class TechManager(Technician, Manager):
    def __init__(self, name, id, specialization, department):
        super().__init__(name, id, specialization)
        self.department = department
        self.subordinates = []

    def add_employee(self, employee):
        self.subordinates.append(employee.get_info().split(', '))

    def get_team_info(self):
        print('Подчиненные работники:', *self.subordinates)

