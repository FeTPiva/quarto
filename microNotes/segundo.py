
msg = "hello"
print(msg)

nome = raw_input("digite seu nome ")
idade = 10
idade = int(raw_input("digite sua idade "))

print(nome)

if(funcao(idade,10)<18):
    print("{} nao pode beber".format(nome))
else:
    print("pode")



array_teste = [1,2,3]
array_teste.append(55)
print(array_teste)


array_tuplas = [(2,"ovo"), (3, "abacate")]
print(array_tuplas)

dicionario = {0:"pao",2:"arroz"}
dicionario[0]
dict2 = {"amigo":5, "amor":404 }
dict2["amor"]

def funcao(big, jhon):
    variavel = big+jhon
    return variavel