terraform {
  backend "s3" {
    bucket = "aliaksei-bialiauski-env-tfstate"
    key = "ticketsyncs-clockfarm/terraform.tfstate"
    region = "us-east-1"
  }
  required_providers {
    heroku = {
      source  = "heroku/heroku"
      version = "5.1.10"
    }
    aws = {
      source  = "hashicorp/aws"
      version = "5.65.0"
    }
  }
}