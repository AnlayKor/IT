from employee import Employee
from manager import Manager
from technician import Technician
from techmanager import TechManager


ordinary_employee = Employee('Карл', 1)
print(ordinary_employee.get_info())
manager_employee = Manager('Мэй', 2, 'по продажам')
print(manager_employee.get_info())
print(manager_employee.manage_project())
technician_employee = Technician('Денис', 3, 'электротехник')
print(technician_employee.get_info())
print(technician_employee.perform_maintenance())
techmanager_employee = TechManager('Лина', 4, 'техник-программист', 'кадров')
print(techmanager_employee.get_info())
print(techmanager_employee.manage_project())
print(techmanager_employee.perform_maintenance())
techmanager_employee.add_employee(ordinary_employee)
techmanager_employee.get_team_info()