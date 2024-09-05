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
    public class PetControllerTests
    {
        private PetController _petController;
        private Mock<IPetRepository> _mocPetRepository;

        public PetControllerTests()
        {
            _mocPetRepository = new Mock<IPetRepository>();
            _petController = new PetController(_mocPetRepository.Object);
        }

        [Fact]
        public void GetAllPetTest()
        {
            List<Pet> list = new List<Pet>();
            list.Add(new Pet());
            list.Add(new Pet());
            list.Add(new Pet());

            _mocPetRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            var operationResult = _petController.GetAll();

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Pet>>(((OkObjectResult)operationResult.Result).Value);

            _mocPetRepository.Verify(repository =>
                repository.GetAll(), Times.AtLeastOnce());
        }

        public static readonly object[][] CorrectCreatePetDate =
        {
            new object[] {1, "Barsik", new DateTime(2024, 5, 20)},
            new object[] {1, "Murka", new DateTime(2022, 1, 10)},
            new object[] {2, "Klaus", new DateTime(2020, 10, 30)},
        };

        [Theory]
        [MemberData(nameof(CorrectCreatePetDate))]
        public void CreatePetsTest(int clientId, string Name, DateTime birthday)
        {
            _mocPetRepository.Setup(repository =>
                repository.Create(It.IsNotNull<Pet>())).Returns(1).Verifiable();

            var operationResult = _petController.Create(new CreatePetRequest
            {
                ClientId = clientId,
                Name = Name,
                Birdthday = birthday
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);

            _mocPetRepository.Verify(repository =>
                repository.Create(It.IsNotNull<Pet>()), Times.AtLeastOnce());
        }
    }
}

    
