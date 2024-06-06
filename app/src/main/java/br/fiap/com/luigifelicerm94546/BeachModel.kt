package br.fiap.com.luigifelicerm94546

data class BeachModel(val name: String, val city: String, val state: String, val onRemove: (BeachModel) -> Unit)
