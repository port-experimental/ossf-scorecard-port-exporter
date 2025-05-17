# ossf-scorecard-port-exporter

## Blueprints

### OSSF Scorecard

```json
{
  "identifier": "ossf_scorecard",
  "title": "ossf scorecard",
  "icon": "Microservice",
  "schema": {
    "properties": {
      "repository": {
        "type": "string",
        "title": "repository"
      },
      "score": {
        "type": "number",
        "title": "score"
      }
    },
    "required": []
  },
  "mirrorProperties": {},
  "calculationProperties": {},
  "aggregationProperties": {},
  "relations": {
    "checks": {
      "title": "checks",
      "target": "ossf_check",
      "required": false,
      "many": true
    }
  }
}
```
### OSSF Check

```json
{
  "identifier": "ossf_check",
  "title": "OSSF Check",
  "icon": "Checklist",
  "schema": {
    "properties": {
      "score": {
        "type": "number",
        "title": "score"
      },
      "reason": {
        "type": "string",
        "title": "reason"
      },
      "name": {
        "type": "string",
        "title": "name"
      }
    },
    "required": []
  },
  "mirrorProperties": {},
  "calculationProperties": {},
  "aggregationProperties": {},
  "relations": {}
}
```
## Create Port Webhook

[Create a new webhook](https://docs.port.io/build-your-software-catalog/custom-integration/webhook/#create-a-custom-webhook) and keep the ingest url somewhere, you will need it. 

## Webhook mapping

```json
[
  {
    "blueprint": "ossf_check",
    "itemsToParse": ".body.checks",
    "entity": {
      "identifier": ".body.repo.name + '/' + .item.name",
      "title": ".item.name",
      "properties": {
        "score": ".item.score",
        "reason": ".item.reason",
        "name": ".body.repo.name + '/' + .item.name"
      }
    }
  },
  {
    "blueprint": "ossf_scorecard",
    "entity": {
      "identifier": ".body.repo.name",
      "properties": {
        "score": ".body.score",
        "repository": ".body.repo.name"
      },
      "relations": {
        "checks": "[.body.repo.name + '/' + .body.checks[].name]"
      }
    }
  }
]
```

## Running the exporter

### Docker

```bash
docker run -i --rm \
  -e PORT_CLIENT_ID="<PORT_CLIENT_ID>" \
  -e PORT_CLIENT_SECRET="<PORT_CLIENT_SECRET>" \
  -e PORT_INGEST_URL="<PORT_INGEST_URL>" \
  -e OSSF_SCORECARD_REPO_URL="<OSSF_SCORECARD_REPO_URL>" \
  sebi2706/ossf-scorecard-port-exporter:0.1
```
That will poll the scorecard result and push it to Port with a default frequency of `5m` , you can change this by the env var : `PORT_SCHEDULER_FREQUENCY`.

## TODOS

- [ ] Add multiple scorecards url sources.
- [ ] Add blueprint autocreation flag.
- [ ] Add Custom Integration autocreation flag.
- [ ] Provide as K8s controller.
- [ ] Make async with Kafka Topic listener.
