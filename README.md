## Requisitos

- Java Development Kit (JDK) 17 ou superior. Confirme com `java -version`;
- Acesso local pela porta padrão do spring boot (`8080`);
- Utilização do H2 (as informações do banco ficam armazenadas na memória da sessão).

## Como executar

Abra um terminal na raiz do repositório e entre na pasta da aplicação:

```bash
cd automanager
```

No Linux ou macOS, permita a execução do wrapper (se necessário) e inicie a aplicação:

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

No Windows, use o Prompt de Comando ou PowerShell:

```bat
mvnw.cmd spring-boot:run
```

Ou, no VSCode, execute a aplicação pela interface gráfica (botão de play).

Espere a mensagem de inicialização do Spring Boot. A API ficará disponível em `http://localhost:8080`.

## Endpoints

### Clientes

| Método e rota | Ação |
| --- | --- |
| `GET /clientes` / `GET /clientes/{id}` | Lista / consulta |
| `POST /clientes` | Cadastra cliente. |
| `PUT /clientes` | Atualiza cliente; informe `id` no JSON. |
| `DELETE /clientes` | Exclui cliente; envie JSON com `id`. |

Exemplo de cadastro:

```bash
curl -X POST http://localhost:8080/clientes \
  -H 'Content-Type: application/json' \
  -d '{
    "nome": "Ana Souza",
    "nomeSocial": "Ana",
    "dataNascimento": "1995-04-12T00:00:00.000+00:00",
    "dataCadastro": "2026-09-27T00:00:00.000+00:00",
    "documentos": [{"tipo": "CPF", "numero": "12345678900"}],
    "endereco": {
      "estado": "SP", "cidade": "São Paulo", "bairro": "Centro",
      "rua": "Rua A", "numero": "100", "codigoPostal": "01000-000",
      "informacoesAdicionais": "Apto 2"
    },
    "telefones": [{"ddd": "11", "numero": "999991234"}]
  }'
```

Consultas e exclusão:

```bash
curl http://localhost:8080/clientes
curl http://localhost:8080/clientes/1
curl -X DELETE http://localhost:8080/clientes \
  -H 'Content-Type: application/json' -d '{"id":1}'
```

Para atualizar cliente, `PUT /clientes` recebe o objeto atualizado com `id` no corpo.

### Documentos

| Método e rota | Ação |
| --- | --- |
| `GET /documentos` / `GET /documentos/{id}` | Lista / consulta. |
| `POST /documentos` | Cadastra documento. |
| `PUT /documentos` | Atualiza; informe `id` no corpo. |
| `DELETE /documentos/{id}` | Exclui pelo identificador. |

```bash
curl -X POST http://localhost:8080/documentos \
  -H 'Content-Type: application/json' \
  -d '{"tipo":"CPF","numero":"12345678900"}'
curl -X PUT http://localhost:8080/documentos \
  -H 'Content-Type: application/json' \
  -d '{"id":1,"tipo":"CPF","numero":"12345678900"}'
curl -X DELETE http://localhost:8080/documentos/1
```

O número do documento é único no banco.

### Endereços

| Método e rota | Ação |
| --- | --- |
| `GET /enderecos` / `GET /enderecos/{id}` | Lista / consulta. |
| `POST /enderecos` | Cadastra endereço. |
| `PUT /enderecos/{id}` | Atualiza o endereço indicado na rota. |
| `DELETE /enderecos/{id}` | Exclui pelo identificador. |

```bash
curl -X POST http://localhost:8080/enderecos \
  -H 'Content-Type: application/json' \
  -d '{"estado":"SP","cidade":"São Paulo","bairro":"Centro","rua":"Rua A","numero":"100","codigoPostal":"01000-000","informacoesAdicionais":"Apto 2"}'
curl -X PUT http://localhost:8080/enderecos/1 \
  -H 'Content-Type: application/json' \
  -d '{"estado":"SP","cidade":"São Paulo","bairro":"Centro","rua":"Rua B","numero":"200"}'
curl -X DELETE http://localhost:8080/enderecos/1
```

### Telefones

| Método e rota | Ação |
| --- | --- |
| `GET /telefones` / `GET /telefones/{id}` | Lista / consulta. |
| `POST /telefones` | Cadastra telefone. |
| `PUT /telefones/{id}` | Atualiza o telefone indicado na rota. |
| `DELETE /telefones/{id}` | Exclui pelo identificador. |

```bash
curl -X POST http://localhost:8080/telefones \
  -H 'Content-Type: application/json' -d '{"ddd":"11","numero":"999991234"}'
curl -X PUT http://localhost:8080/telefones/1 \
  -H 'Content-Type: application/json' -d '{"ddd":"11","numero":"988881234"}'
curl -X DELETE http://localhost:8080/telefones/1
```
