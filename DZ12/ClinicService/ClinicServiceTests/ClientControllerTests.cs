using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClinicServiceTests
{
    public class ClientControllerTests
    {
        private ClientController _clientController;
        private Mock<IClientRepository> _mocClientRepository;

        public ClientControllerTests()
        {
            _mocClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mocClientRepository.Object);
        }

        [Fact]
        public void GetAllClientsTest()
        {
            // [1.1] Подготовка данных для тестирования

            // [1.2]
            List<Client> list = new List<Client>();
            list.Add(new Client());
            list.Add(new Client());
            list.Add(new Client());

            _mocClientRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            // [2] Исролнение тестируемого метода
            var operationResult = _clientController.GetAll();

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Client>>(((OkObjectResult)operationResult.Result).Value);

            _mocClientRepository.Verify(repository =>
                repository.GetAll(), Times.AtLeastOnce());
        }

        public static readonly object[][] CorrectCreateClientDate =
        {
            new object[] { new DateTime(1985, 5, 20), "1234 123456", "Иванов", "Иван", "Иваныч" },
            new object[] { new DateTime(1982, 3, 20), "1235 123456", "Иванов", "Петр", "Иваныч" },
            new object[] { new DateTime(1979, 1, 20), "1236 123456", "Иванов", "Антон", "Иваныч" }
        };

        [Theory]
        [MemberData(nameof(CorrectCreateClientDate))]
        public void CreateClientsTest(DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            _mocClientRepository.Setup(repository =>
                repository.Create(It.IsNotNull<Client>())).Returns(1).Verifiable();

            var operationResult = _clientController.Create(new CreateClientRequest
            {
                Birdthday = birthday,
                Document = document,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);

            _mocClientRepository.Verify(repository =>
                repository.Create(It.IsNotNull<Client>()), Times.AtLeastOnce());
        }
    }
}
