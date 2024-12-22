from employee import Employee


class Technician(Employee):
    def __init__(self, name, id, specialization):
        super().__init__(name, id)
        self.specialization = specialization

    def get_info(self):
        return f'{super().get_info()}, специализация: {self.specialization}'

    def perform_maintenance(self):
        return f'Выполняет техническое обслуживание по специализации {self.specialization}'
