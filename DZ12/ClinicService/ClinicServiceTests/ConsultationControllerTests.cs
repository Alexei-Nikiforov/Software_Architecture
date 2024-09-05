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
    public class ConsultationControllerTests
    {
        private ConsultationController _consultationController;
        private Mock<IConsultationRepository> _mocConsultationRepository;

        public ConsultationControllerTests()
        {
            _mocConsultationRepository = new Mock<IConsultationRepository>();
            _consultationController = new ConsultationController(_mocConsultationRepository.Object);
        }

        [Fact]
        public void GetAllConsultationTest()
        {
            List<Consultation> list = new List<Consultation>();
            list.Add(new Consultation());
            list.Add(new Consultation());
            list.Add(new Consultation());

            _mocConsultationRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            var operationResult = _consultationController.GetAll();

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Consultation>>(((OkObjectResult)operationResult.Result).Value);

            _mocConsultationRepository.Verify(repository =>
                repository.GetAll(), Times.AtLeastOnce());
        }

        public static readonly object[][] CorrectCreateConsultationDate =
        {
            new object[] {1, 1, new DateTime(2024, 9, 5), "Обследование"},
            new object[] {1, 2, new DateTime(2024, 9, 5), "Обследование"},
            new object[] {2, 3, new DateTime(2020, 10, 30), "Обследование"}
        };

        [Theory]
        [MemberData(nameof(CorrectCreateConsultationDate))]
        public void CreateConsultationsTest(int clientId, int petId, DateTime consultationsDay, string descriotion)
        {
            _mocConsultationRepository.Setup(repository =>
                repository.Create(It.IsNotNull<Consultation>())).Returns(1).Verifiable();

            var operationResult = _consultationController.Create(new CreateConsultationRequest
            {
                ClientId = clientId,
                PetId = petId,
                ConsultationsDate = consultationsDay,
                Description = descriotion
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);

            _mocConsultationRepository.Verify(repository =>
                repository.Create(It.IsNotNull<Consultation>()), Times.AtLeastOnce());
        }
    }
}
