package mesosphere.marathon.client.model.v2

import mesosphere.client.common.ModelUtils
import mesosphere.marathon.client.model.v2.app.App
import mesosphere.marathon.client.model.v2.app.Residency
import spock.lang.Specification

class AppSpec extends Specification {

  def app = new App()

  def "allows multiple roles"() {
	def firstRole = "arole"
	def secondRole = "another"

	when:
	app.addAcceptedResourceRole(firstRole)

	then:
	app.acceptedResourceRoles.contains(firstRole)

	when:
	app.addAcceptedResourceRole(secondRole)

	then:
	app.acceptedResourceRoles.contains(firstRole)
	app.acceptedResourceRoles.contains(secondRole)

	when:
	app.addAcceptedResourceRole(firstRole)

	then:
	app.acceptedResourceRoles.contains(firstRole)
  }


  def "test add dependency"() {
	def firstDep = "adep"
	def secondDep = "another"

	when:
	app.addDependency(firstDep)

	then:
	app.getDependencies().contains(firstDep)

	when:
	app.addDependency(secondDep)

	then:
	app.getDependencies().contains(firstDep)
	app.getDependencies().contains(secondDep)

	when:
	app.addDependency(firstDep)

	then:
	app.getDependencies().contains(firstDep)

  }

  def "backoff factor checks"() {
	app.backoffFactor = 0.1

	expect:
	app.backoffFactor == 0.1

	when:
	app.backoffFactor = 1d

	then:
	app.backoffFactor == 1.0
  }

  def "residency tests"() {
	def residency = new Residency()
	residency.relaunchEscalationTimeoutSeconds = 60
	residency.taskLostBehavior = "WAIT_FOREVER"

	expect:
	!app.residency

	when:
	app.residency = residency

	then:
	app.residency.relaunchEscalationTimeoutSeconds == 60
	app.residency.taskLostBehavior == "WAIT_FOREVER"

	when:
	app.residency.taskLostBehavior = "INVALID_BEHAVIOR"

	then:
	app.residency.taskLostBehavior == "INVALID_BEHAVIOR"
  }

  def "test example JSON"() {
	given:
	def json = exampleJSON()

	def app = ModelUtils.GSON.fromJson(json, App.class)
	def portDefs = app.getPortDefinitions()
	def fetch2 = app.fetch[1]
	def discovery = app.ipAddress.discovery

	expect:
	// env
	app.getEnv().get("PASSWORD") == ["secret": "/db/password"]

	// port definitions
	portDefs.size() == 2
	portDefs[0].port == 0
	portDefs[0].protocol == "tcp"
	portDefs[0].name == "http"
	portDefs[0].labels == ["vip": "192.168.0.1:80"]
	portDefs[1].port == 31009
	portDefs[1].protocol == "tcp"
	portDefs[1].labels == ["VIP_0": "3.3.3.3"]

	// fetch
	app.fetch.size() == 2
	fetch2.uri == "https://foo.com/archive.zip"
	!fetch2.executable
	fetch2.extract
	fetch2.cache
	fetch2.destPath == "newname.zip"

	//secrets
	app.secrets.size() == 2
	app.secrets.secret3.source == "/foo2"

	// ipaddress
	discovery.ports.size() == 1
	discovery.ports[0].number == 8080
	discovery.ports[0].name == "rest-endpoint"
	app.ipAddress.labels["environment"] == "dev"
	app.ipAddress.groups[0] == "dev"

	// residency
	app.residency.relaunchEscalationTimeoutSeconds == 60
	app.residency.taskLostBehavior == "WAIT_FOREVER"

	// container.docker.portMappings
	app.container.docker.portMappings[0].name == "http"
	app.container.docker.portMappings[0].protocol == "tcp"
	app.container.docker.portMappings[0].containerPort == 80
	app.container.docker.portMappings[0].servicePort == 10019

	// container.docker.network
	app.container.docker.network == "BRIDGE"

  }

  def "test example JSON 1.5"() {
	given:
	def json = exampleJSON_15()

	def app = ModelUtils.GSON.fromJson(json, App.class)

	expect:
	// container.portMappings
	app.container.portMappings[0].name == "http"
	app.container.portMappings[0].protocol == "tcp"
	app.container.portMappings[0].containerPort == 80
	app.container.portMappings[0].servicePort == 10019

	// networks
	app.networks[0].name == "default"
	app.networks[0].mode == "container/bridge"

  }

	def "test example JSON 1.6 with IPv6"() {
		given:
		def json = exampleJSON_16()

		def app = ModelUtils.GSON.fromJson(json, App.class)

		expect:
		app.healthChecks[0].ipProtocol == "IPv6"
	}

	def "test example JSON 1.6 without ipProtocol defined"() {
		given:
		def json = exampleJSON()

		def app = ModelUtils.GSON.fromJson(json, App.class)

		expect:
		// we don't default the protocol
		app.healthChecks[0].ipProtocol == null

	}

	def exampleJSON() {
	return """
{
  "id": "/foo",
  "instances": 2,
  "cmd": "sleep 1000",
  "cpus": 0.1,
  "disk": 0,
  "mem": 16,
  "acceptedResourceRoles": [
	"mesos_role"
  ],
  "args": [
	"sleep",
	"100"
  ],
  "backoffFactor": 1.15,
  "backoffSeconds": 1,
  "constraints": [
	[
	  "hostname",
	  "LIKE",
	  "srv2.*"
	]
  ],
  "container": {
	"docker": {
	  "forcePullImage": false,
	  "image": "mesosphere:marathon/latest",
	  "network": "BRIDGE",
	  "parameters": [
		{
		  "key": "name",
		  "value": "kdc"
		}
	  ],
	  "portMappings": [
		{
		  "containerPort": 80,
		  "hostPort": 0,
		  "protocol": "tcp",
		  "servicePort": 10019,
		  "name": "http",
		  "labels": {
			"vip": "192.168.0.1:80"
		  }
		}
	  ],
	  "privileged": false
	},
	"type": "DOCKER",
	"volumes": [
	  {
		"containerPath": "/docker_storage",
		"hostPath": "/hdd/tools/docker/registry",
		"mode": "RW"
	  }
	]
  },
  "dependencies": [
	"/prod/group"
  ],
  "env": {
	"XPS1": "Test",
	"XPS2": "Rest",
	"PASSWORD": {
	  "secret": "/db/password"
	}
  },
  "executor": "",
  "healthChecks": [
	{
	  "gracePeriodSeconds": 300,
	  "ignoreHttp1xx": false,
	  "intervalSeconds": 20,
	  "maxConsecutiveFailures": 3,
	  "path": "/",
	  "portIndex": 0,
	  "protocol": "HTTP",
	  "timeoutSeconds": 20
	}
  ],
  "readinessChecks": [
	{
	  "name": "myReadyCheck",
	  "protocol": "HTTP",
	  "path": "/v1/plan",
	  "portName": "http",
	  "intervalSeconds": 10,
	  "timeoutSeconds": 3,
	  "httpStatusCodesForReady": [
		200
	  ],
	  "preserveLastResponse": true
	}
  ],
  "labels": {
	"owner": "zeus",
	"note": "Away from olympus"
  },
  "maxLaunchDelaySeconds": 3600,
  "ipAddress": {
	"discovery": {
	  "ports": [
		{
		  "number": 8080,
		  "name": "rest-endpoint",
		  "protocol": "tcp"
		}
	  ]
	},
	"groups": [
	  "dev"
	],
	"labels": {
	  "environment": "dev"
	}
  },
  "portDefinitions": [
	{
	  "port": 0,
	  "protocol": "tcp",
	  "name": "http",
	  "labels": {
		"vip": "192.168.0.1:80"
	  }
	},
	{
	  "port": 31009,
	  "protocol": "tcp",
	  "labels": {
		"VIP_0": "3.3.3.3"
	  }
	}
  ],
  "requirePorts": false,
  "upgradeStrategy": {
	"maximumOverCapacity": 1,
	"minimumHealthCapacity": 1
  },
  "fetch": [
	{
	  "uri": "https://foo.com/setup.py"
	},
	{
	  "uri": "https://foo.com/archive.zip",
	  "executable": false,
	  "extract": true,
	  "cache": true,
	  "destPath": "newname.zip"
	}
  ],
  "user": "root",
  "secrets": {
	"secret1": {
	  "source": "/db/password"
	},
	"secret3": {
	  "source": "/foo2"
	}
  },
  "taskKillGracePeriodSeconds": 30,
  "residency": {
	"relaunchEscalationTimeoutSeconds": 60,
	"taskLostBehavior": "WAIT_FOREVER"
  }
}
"""
  }

  def exampleJSON_15() {
	return """
{
  "id": "/foo",
  "instances": 2,
  "cmd": "sleep 1000",
  "cpus": 0.1,
  "disk": 0,
  "mem": 16,
  "container": {
	"docker": {
	  "forcePullImage": false,
	  "image": "mesosphere:marathon/latest",
	  "parameters": [
		{
		  "key": "name",
		  "value": "kdc"
		}
	  ],
	  "privileged": false
	},
	"type": "DOCKER",
	"volumes": [
	  {
		"containerPath": "/docker_storage",
		"hostPath": "/hdd/tools/docker/registry",
		"mode": "RW"
	  }
	],
	"portMappings": [
	  {
		"containerPort": 80,
		"hostPort": 0,
		"protocol": "tcp",
		"servicePort": 10019,
		"name": "http",
		"labels": {
		  "vip": "192.168.0.1:80"
		}
	  }
	]
  },
  "networks": [
	{
	  "name": "default",
	  "mode": "container/bridge",
	  "labels": {}
	}
  ]
}
"""
  }

	def exampleJSON_16() {
		return """
{
  "id": "/foo",
  "instances": 2,
  "cmd": "sleep 1000",
  "cpus": 0.1,
  "container": {
	"docker": {
	  "image": "mesosphere:marathon/latest"
	},
	"type": "DOCKER"
  },
  "healthChecks": [
	{
	  "gracePeriodSeconds": 300,
	  "ignoreHttp1xx": false,
	  "intervalSeconds": 20,
	  "maxConsecutiveFailures": 3,
	  "path": "/",
	  "portIndex": 0,
	  "protocol": "HTTP",
	  "timeoutSeconds": 20,
	  "ipProtocol" : "IPv6"
	}
  ],
  "user": "root"
}
"""
	}
}
