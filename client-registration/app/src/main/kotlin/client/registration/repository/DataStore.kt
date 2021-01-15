package client.registration.repository;
import client.registration.dto.Client;

interface DataStore {
  fun save(client: Client)
}