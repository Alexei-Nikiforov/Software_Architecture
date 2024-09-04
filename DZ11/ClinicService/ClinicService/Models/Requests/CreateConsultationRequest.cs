namespace ClinicService.Models.Requests
{
    public class CreateConsultationRequest
    {
        public int ClientId { get; set; }
        public int PetId { get; set; }
        public DateTime ConsultationsDate { get; set; }
        public string Description { get; set; }
    }
}
