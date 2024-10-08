﻿using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using MyFirstWebApplication.Models;

namespace MyFirstWebApplication.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class WeatherForecastController : ControllerBase
    {
        private WeatherForecastHolder _weatherForecastHolder;

        public WeatherForecastController(
            WeatherForecastHolder weatherForecastHolder)
        {
            _weatherForecastHolder = weatherForecastHolder;
        }

        [HttpPost("add")]
        public IActionResult Add([FromQuery] DateTime date, [FromQuery] int temperatureC)
        {
            _weatherForecastHolder.Add(date, temperatureC);
            return Ok();
        }

        [HttpPut("update")]
        public IActionResult Update([FromQuery] DateTime date, [FromQuery] int temperatureC)
        {
            bool updates = _weatherForecastHolder.Update(date, temperatureC);

            if(updates)
            {
                return Ok();
            } 
            else
            {
                return NotFound(); // Ошибка 404
            }
        }

        [HttpDelete("delete")]
        public IActionResult Dalete([FromQuery] DateTime date)
        {
            bool deletes = _weatherForecastHolder.Delete(date);

            if (deletes)
            {
                return Ok();
            }
            else
            {
                return NotFound(); // Ошибка 404
            }
        }

        [HttpGet("get")]
        public IActionResult Get([FromQuery] DateTime dateFrom, [FromQuery] DateTime dateTo)
        {
            List<WeatherForecast> list = _weatherForecastHolder.Get(dateFrom, dateTo);
            return Ok(list);
        }
    }
}
